export class DataModel {

  id?: number;
  name?: string;
  status?: string;
  modifyBy?: string;
  modifyDate?: Date;
  description?: any;
  triggerdateLbman?: boolean;
  triggerdateSvcscat?: any;
  triggerdateItem?: boolean;
  isinterimtrigger?: boolean;
  constraintLbman?: boolean;
  constraintSvcscat?: any;
  constraintItem?: boolean;
  purma?: boolean;
  nntm?: boolean;
  pdbtm?: boolean;
  dsart?: boolean;
  trigger?: number;
  interimtrigger?: number;
  constraint?: number;
  lbmanEffectivedeadlineinfo?: number;
  lbmanProcbasisref?: number;
  editable?: boolean;

  constructor(id?: number,
              name?: string,
              status?: string,
              modifyBy?: string,
              modifyDate?: Date,
              description?: any,
              triggerdateLbman?: boolean,
              triggerdateSvcscat?: any,
              triggerdateItem?: boolean,
              isinterimtrigger?: boolean,
              constraintLbman?: boolean,
              constraintSvcscat?: any,
              constraintItem?: boolean,
              purma?: boolean,
              nntm?: boolean,
              pdbtm?: boolean,
              dsart?: boolean,
              trigger?: number,
              interimtrigger?: number,
              constraint?: number,
              lbmanEffectivedeadlineinfo?: number,
              lbmanProcbasisref?: number,
              editable?: boolean) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.modifyBy = modifyBy;
    this.modifyDate = modifyDate;
    this.description = description;
    this.triggerdateLbman = triggerdateLbman;
    this.triggerdateSvcscat = triggerdateSvcscat;
    this.triggerdateItem = triggerdateItem;
    this.isinterimtrigger = isinterimtrigger;
    this.constraintLbman = constraintLbman;
    this.constraintSvcscat = constraintSvcscat;
    this.constraintItem = constraintItem;
    this.purma = purma;
    this.nntm = nntm;
    this.pdbtm = pdbtm;
    this.dsart = dsart;
    this.trigger = trigger;
    this.interimtrigger = interimtrigger;
    this.constraint = constraint;
    this.lbmanEffectivedeadlineinfo = lbmanEffectivedeadlineinfo;
    this.lbmanProcbasisref = lbmanProcbasisref;
    this.editable = editable;
  }

}
