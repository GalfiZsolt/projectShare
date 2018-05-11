export class Donation {
  public id?: any;
  public title?: string;
  public description?: string;
  public type?: string;
  public quantity?: string;
  public createdBy?: string;
  public createdDate?: Date;
  public lastModifiedBy?: string;
  public lastModifiedDate?: Date;

  constructor(
    id?: any,
    title?: string,
    description?: string,
    type?: string,
    quantity?: string,
    createdBy?: string,
    createdDate?: Date,
    lastModifiedBy?: string,
    lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.title = title ? title : null;
    this.description = description ? description : null;
    this.type = type ? type : null;
    this.quantity = quantity ? quantity : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
