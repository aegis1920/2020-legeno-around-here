import React, { useEffect, useState } from 'react';
import BottomBlank from '../../BottomBlank';
import Bottom from '../../Bottom';
import { PROFILE } from '../../../constants/BottomItems';
import TopBar from '../myProfile/myProfileTopBar';
import { findAllOtherAwards, findMyAwards } from '../../api/API';
import Loading from '../../Loading';
import { getAccessTokenFromCookie } from '../../../util/TokenUtils';
import Awards from '../myAward/Awards';

const OtherAwardPage = ({ match }) => {
  const accessToken = getAccessTokenFromCookie();
  const [awards, setAwards] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const loadOtherAwards = async () => {
      setLoading(true);
      const foundMyAwards = await findAllOtherAwards(accessToken, match.params.userId);
      console.log(foundMyAwards);
      setAwards(foundMyAwards);
      setLoading(false);
    };
    loadOtherAwards();
  }, [accessToken]);

  if (loading) {
    return <Loading />;
  }
  return (
    <>
      <TopBar />
      <Awards awards={awards} />
      <BottomBlank />
      <Bottom selected={PROFILE} />
    </>
  );
};

export default OtherAwardPage;
