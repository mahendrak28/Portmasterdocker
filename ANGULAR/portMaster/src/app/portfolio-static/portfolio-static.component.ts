import { Component, OnInit, ViewChild } from '@angular/core';
import { PortfolioStaticService } from '../service/portfolioStatic.service';
import { AgGridAngular } from 'ag-grid-angular';

@Component({
  selector: 'app-portfolio-static',
  template: `
  <h2> Porfolio Static Information </h2>
  <button (click)="getSelectedRows()">Get Selected Rows</button>
  <button (click)="onAddRow()">Add Row</button>
  <button (click)="onSaveRow()">Save Selected Row</button>
  <button (click)="onRemoveSelected()">Delete Selected Row</button>
    <ag-grid-angular
    #agGrid
    style="width: 1500px; height: 1000px;"
    class="ag-theme-balham"
    [rowData]="portfolioStatic"
    [columnDefs]="columnDefs"
    rowSelection="multiple"
    [animateRows]="true"
    (gridReady)="onGridReady($event)"
    >
</ag-grid-angular>
    `,
  styleUrls: ['./portfolio-static.component.scss']
})
export class PortfolioStaticComponent implements OnInit {
  private gridApi;
  private gridColumnApi;
  @ViewChild('agGrid', { static: true }) agGrid: AgGridAngular;

  public portfolioStatic = [];

  constructor(private _PORTSTATIC: PortfolioStaticService) { }
  columnDefs = [
    {headerName: 'ID', field: 'id' , sortable: true, filter: true, checkboxSelection: true, editable: true },
    {headerName: 'Port Id', field: 'port_Id', sortable: true, filter: true, editable: true },
    {headerName: 'Port Name', field: 'port_name', sortable: true, filter: true, editable: true},
    {headerName: 'Port Status', field: 'port_status', sortable: true, filter: true, editable: true},
    {headerName: 'Port Summary Flag', field: 'port_summary_flag', sortable: true, filter: true, editable: true},
    {headerName: 'Updated By', field: 'last_update_status_user', sortable: true, filter: true, editable: true},
    {headerName: 'Updated Date', field: 'last_update_status_date', sortable: true, filter: true, editable: true}
  ];

  ngOnInit() {
    this._PORTSTATIC.getPortfolio()
    .subscribe(data => this.portfolioStatic = data);
  }
  getSelectedRows() {
    const selectedNodes = this.agGrid.api.getSelectedNodes();
    const selectedData = selectedNodes.map( node => node.data );
    const selectedDataStringPresentation = selectedData.map( node => node.id + ' ' + node.port_Id).join(', ');

   // this._PORTSTATIC.createPortfolio(selectedData);
    alert(`Selected nodes: ${selectedDataStringPresentation}`);
}
onGridReady(params) {
  this.gridApi = params.api;
  this.gridColumnApi = params.columnApi;
}
onAddRow() {
  const newItem = this.createNewRowData();
  const res = this.gridApi.updateRowData({ add: [newItem] });
 // this.printResult(res);
    // this._PORTSTATIC.createPortfolio();
}

onSaveRow() {
  const selectedNodes = this.agGrid.api.getSelectedNodes();
  const selectedData = selectedNodes.map( node => node.data );

  this._PORTSTATIC.createPortfolio(selectedData);
//  this.printResult(selectedData);
}
onRemoveSelected() {
  const selectedData = this.gridApi.getSelectedRows();

  const selectedDataStringPresentation = selectedData.map(node => node.id);

  this._PORTSTATIC.deletePortfolio(selectedDataStringPresentation).subscribe();
  const res = this.gridApi.updateRowData({ remove: selectedData });


 // this.printResult(res);
}

createNewRowData() {
  const newData = {
    id: '',
    port_Id: '',
    port_name: '',
    port_status: '',
    port_summary_flag: '',
    last_update_status_user: '',
    last_update_status_date: ' '
  };
  return newData;
}
/* printResult(res) {
  console.log('---------------------------------------');
  if (res.add) {
    res.add.forEach(function(rowNode) {
      console.log('Added Row Node', rowNode);
    });
  }
  if (res.remove) {
    res.remove.forEach(function(rowNode) {
      console.log('Removed Row Node', rowNode);
    });
  }

}*/
}
