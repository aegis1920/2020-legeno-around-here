import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import IconButton from '@material-ui/core/IconButton';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import SendIcon from '@material-ui/icons/Send';
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import handleBackButtonClicked from '../../../util/BackButtonHandler';

const useStyles = makeStyles((theme) => ({
  grow: {
    flexGrow: 1,
  },
}));

const PostingTopBar = () => {
  const classes = useStyles();

  return (
    <AppBar position='absolute'>
      <Toolbar>
        <IconButton edge='start' color='inherit' aria-label='open drawer' onClick={handleBackButtonClicked}>
          <ArrowBackIcon />
        </IconButton>
        <div className={classes.grow} />
        <IconButton edge='end' color='inherit' aria-label='open drawer' type='submit' form='posting-form'>
          <SendIcon />
        </IconButton>
      </Toolbar>
    </AppBar>
  );
};

export default PostingTopBar;
