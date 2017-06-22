import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';



const NewItemRegisterComponent = React.createClass({

    getInitialState: function () {
        return {
            itemTitle: '',
            itemWeight: '',
            sector: '',
            insertDate: '',
        };
    },

    handleItemTitleChange: function (event) {
        this.setState({ itemTitle: event.target.value })
    },

    handleItemWeightChange: function (event) {
        this.setState({ itemWeight: event.target.value })
    },

    handleSectorChange: function (event) {
        this.setState({ sector: event.target.value })
    },

    handleInsertDateChange: function (event) {
        this.setState({ insertDate: event.target.value })
    },

 
    registerItem: function () {
        axios.post('http://localhost:8080/api/items', {
            itemTitle: this.state.itemTitle,
            itemWeight: this.state.itemWeight,
            sector: this.state.sector,
            insertDate: this.state.insertDate,
        }).then(result => window.location = "#/");
    },


    render() {
        return (
            <div>
                <form>
                    <fieldset>
                        <h2><label>Register item</label></h2>
            
                        <div className="form-group">
                            <label htmlFor="itemTitle">Item title:</label>
                            <input className="form-control" id="itemTitle" name="itemTitle" value={this.props.itemTitle} onChange={this.handleItemTitleChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="itemWeight">Item weight: </label>
                            <input className="form-control" id="itemWeight" name="itemWeight" value={this.props.itemWeight} onChange={this.handleItemWeightChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="sector">Sector:</label>
                            <input className="form-control" id="sector" name="sector" value={this.props.sector} onChange={this.handleSectorChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="insertDate">Insert date: </label>
                            <input className="form-control" id="insertDate" name="insertDate" value={this.props.insertDate} onChange={this.handleInsertDateChange} />
                        </div>

                        <div className="form-group">
                            <input className="btn btn-primary" id="registerBtn" type="button"                            
                                value="Register" onClick={this.registerItem} />
                        </div>

                        <div>
                            
                        </div>
                    </fieldset>
                </form>
            </div>
        )
    }
});

export default NewItemRegisterComponent;