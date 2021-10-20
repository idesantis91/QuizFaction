import React from 'react';
import { Paper, withStyles, Typography, TextField, Button } from '@material-ui/core';
import AccountService from '../services/AccountService';

const styles = theme => ({
    margin: {
        margin: theme.spacing.unit * 2,
    },
    padding: {
        padding: theme.spacing.unit
    }
});

class LoginTab extends React.Component {

  
  constructor(props) {
    super(props)

    this.onChangeUserName = this.onChangeUserName.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);

    this.state = {
        username: '',
        password: ''
    }
}

  handleSubmit = (e) => {
    e.preventDefault();

    const account = {
      username: this.state.username,
      password: this.state.password,
    }

    AccountService.createAccount(account)
  }

    onChangeUserName(e) {
      this.setState({ username: e.target.value })
  }

  onChangePassword(e) {
      this.setState({ password: e.target.value })
  }

  handleChange = e => {
    this.setState({ [e.currentTarget.id]: e.currentTarget.value });
  };

    render() {
        const { classes } = this.props;
        return( <div >
          <Paper className={classes.root}>
              <form className={classes.container} onSubmit={this.handleSubmit} >
                  <TextField                    
                      id={"username"}
                      placeholder="username"
                      onInput={this.onChangeUserName}
                      onChange={this.handleChange}
                      autoComplete="off"
                      formControlProps={{
                        fullWidth: true
                      }}
                  />
                  <TextField                      
                      id={"password"}
                      placeholder="password"
                      onInput={this.onChangePassword}
                      onChange={this.handleChange}
                      autoComplete="off"
                      formControlProps={{
                        fullWidth: true
                      }}                     
                  />
                  <Typography className={classes.divider} />
                  <Button
                      type="submit"
                      className={classes.button}
                  >Login
                  </Button>
              </form>
          </Paper>
      </div>
  );
    }
}

export default withStyles(styles)(LoginTab);