import * as React from "react";

import * as sessions from "../../static_data/sessions.json";
import { AgGridReact } from "ag-grid-react";
import "ag-grid-community/dist/styles/ag-grid.css";
import "ag-grid-community/dist/styles/ag-theme-balham.css";
import "ag-grid-enterprise";

export interface GridContainerProps {}

export interface GridContainerState {}

class GridContainer extends React.Component<
  GridContainerProps,
  GridContainerState
> {
  state = {
    defaultColDef: {
      width: 150,
      filter: true,
      sortable: true
    },
    columnDefs: [
      {
        headerName: "Session Id",
        field: "session_id"
      },
      {
        headerName: "Created At",
        field: "created_at",
        enableRowGroup: true
      },
      {
        headerName: "Destroyed At",
        field: "destroyed_at",
        enableRowGroup: true
      },
      {
        headerName: "Duration",
        field: "duration",
        enableRowGroup: true
      },
      {
        headerName: "Number of Users",
        field: "num_users"
      }
    ],
    rowData: sessions.data
  };

  render() {
    return (
      <div
        id="sessionGrid"
        className="ag-theme-balham"
        style={{
          height: "570px",
          width: "750px"
        }}
      >
        <AgGridReact
          defaultColDef={this.state.defaultColDef}
          columnDefs={this.state.columnDefs}
          rowData={this.state.rowData}
          rowGroupPanelShow="always"
        ></AgGridReact>
      </div>
    );
  }
}

export default GridContainer;
