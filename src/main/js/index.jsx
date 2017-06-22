import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, hashHistory } from 'react-router';

import ClientTableComponent from './components/client_table_component.jsx';
import ClientCreationComponent from './components/client_creation_component.jsx';
import NewItemRegisterComponent  from './components/new_item_register_component.jsx';

export const App = React.createClass({
    render: function () {
        return (
            <div>
                <nav className="navbar navbar-inverse bg-inverse">
                    <a className="navbar-brand" href="#/">View Clients</a>
                    <a className="navbar-brand" href="#/createClient">Create Client</a>
                    <a className="navbar-brand" href="#/registerNewItem">Register new item</a>
                </nav>

                <Router history={hashHistory}>
                    <Route path="/" component={ClientTableComponent} />
                    <Route path="/createClient" component={ClientCreationComponent} />
                    <Route path="/registerNewItem" component={NewItemRegisterComponent} />
                </Router>
            </div>
        );
    }
});

ReactDOM.render(<App />, document.getElementById('root'));
