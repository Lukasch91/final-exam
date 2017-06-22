import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';


const ClientCreationComponent = React.createClass({

    getInitialState: function () {
        return { firstName: '', lastName: '', birthDate: '', phoneNumber: '', clientType: '' };
    },

    handleFirstNameChange: function (event) {
        this.setState({ firstName: event.target.value })
    },

    handleLastNameChange: function (event) {
        this.setState({ lastName: event.target.value })
    },

    handleBirthDateChange: function (event) {
        this.setState({ birthDate: event.target.value })
    },


    handlePhoneNumberChange: function (event) {
        this.setState({ phoneNumber: event.target.value })
    },


    handleClientTypeChange: function (event) {
        this.setState({ clientType: event.target.value })
    },


    registerClient: function () {
        axios.post('http://localhost:8080/api/clients', {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            birthDate: this.state.birthDate,
            phoneNumber: this.state.phoneNumber,
            clientType: this.state.clientType
        }).then(result => window.location = "#/");
    },

    render() {
        return (
            <div>
                <form>
                    <fieldset>
                        <legend>Register a client</legend>
                        <div className="form-group">
                            <label htmlFor="firstName">First Name:</label>
                            <input className="form-control" id="firstName" name="firstName" value={this.props.firstName} onChange={this.handleFirstNameChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="lastName">Last Name: </label>
                            <input className="form-control" id="lastName" name="lastName" value={this.props.lastName} onChange={this.handleLastNameChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="birthDate">Birthday:</label>
                            <input className="form-control" id="birthDate" name="birthDate" value={this.props.birthDate} onChange={this.handleBirthDateChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="phoneNumber">Phone number: </label>
                            <input className="form-control" id="phoneNumber" name="phoneNumber" value={this.props.phoneNumber} onChange={this.handlePhoneNumberChange} />
                        </div>

                        <div className="form-group">
                            <label htmlFor="clientType">Client type: </label>
                            <input className="form-control" id="clientType" name="clientType" value={this.props.clientType} onChange={this.handleClientTypeChange} />
                        </div>

                        <div className="form-group">
                            <input className="btn btn-primary" id="registerBtn" type="button" 
                            disabled={this.state.firstName === '' || 
                            this.state.lastName === '' || 
                            this.state.birthDate === ''|| 
                            this.state.phoneNumber === '' || 
                            this.state.clientType === ''} 
                            value="Register" onClick={this.registerClient} />
                        </div>
                    </fieldset>
                </form>
            </div>
        )
    }
});

export default ClientCreationComponent;