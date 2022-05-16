import {Component, OnInit} from '@angular/core';
import {DataService} from "../data-service";
import {DataModel} from "../data-model";
import {AddDialogComponent} from "../add-dialog/add-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {Observable} from 'rxjs';

@Component({
  selector: 'list-component',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  dataModels: DataModel[] = [];
  displayedColumns = ["name", "modifyBy", "status"];

  constructor(private dataService: DataService, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.dataService.getDataFromJsonFile().subscribe((response) => {
      this.dataModels = response;
    });
  }

  addData(): void {
    const dialogRef = this.dialog.open(AddDialogComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.dataModels = this.dataModels.concat(result);
      }
    });
  }

}
