import React from 'react';
import { Paper, withStyles, Typography, TextField, Button } from '@material-ui/core';
import AccountService from '../services/AccountService';

const styles = theme => ({
  root: {
    backgroundColor: "#E1FAFA",
    alignItems:"center",
    justifyContent:"center",
    minHeight: '100vh',
    margin: "auto",
    display: "flex"
  },
  container:{
    justifyContent:"center",
    backgroundColor: "#96C3D7",
    alignItems:"center",
    borderRadius: "10px",
    minHeight: "500px",
    minWidth: "500px",
    display:"grid",
    margin: "auto"
  },
  button:{
    justifyContent:"center",
    alignItems:"center",
    display: "flex",
    margin: "auto"
  }
});

class CreateTab extends React.Component {

  
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
                  <TextField className={classes.divider}                   
                      id={"username"}
                      placeholder="username"
                      onInput={this.onChangeUserName}
                      onChange={this.handleChange}
                      autoComplete="off"
                      formControlProps={{
                        fullWidth: true
                      }}
                  />
                  <TextField className={classes.divider}                     
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
                  >Create Account
                  </Button>
              </form>
          </Paper>
      </div>
  );
    }
}

export default withStyles(styles)(CreateTab);