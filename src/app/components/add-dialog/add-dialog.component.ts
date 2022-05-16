import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ListComponent} from "../list/list.component";
import {DataModel} from "../data-model";

@Component({
  selector: 'add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent {

  data = new DataModel();
  selectedStatus: any;
  constructor(public dialogRef: MatDialogRef<AddDialogComponent>) { }

  cancel(): void {
    this.dialogRef.close();
  }

  save() {
    this.data.status = this.selectedStatus;
    this.data.modifyBy = 'admin';
    this.data.modifyDate = new Date();
    this.dialogRef.close(this.data);
  }
}
