import React from 'react';

import PostingTopBar from './PostingTopBar';
import PostingForm from './PostingForm';
import Container from '@material-ui/core/Container';

const PostingPage = () => {
  return (
    <>
      <PostingTopBar />
      <Container style={{ paddingTop: '60px' }}>
        <PostingForm />
      </Container>
    </>
  );
};

export default PostingPage;
