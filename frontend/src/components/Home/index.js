import { useEffect, useState } from 'react';
import Loader from 'react-loaders';
import { Link } from 'react-router-dom';
import LogoPL from '../../logo.png';
import AnimatedLetters from '../AnimatedLetters';
import './index.scss';

const Home = () => {
    const [letterClass, setLetterClass] = useState('text-animate')
    const nameArray = "Welcome to".split("");
    const jobArray = "Premier Zone".split("");

    useEffect(() => {
        const timerId = setTimeout(() => {
          setLetterClass('text-animate-hover');
        }, 4000);
      
        return () => {
          clearTimeout(timerId);
        };
      }, []);

    return(
      <>
          <div className="container home-page">
              <div className="text-zone">
                  <h1>
                      <img src={LogoPL} alt="PremierZone" />
                      <br />

                      <div style={{ color: "black" }}>
                          <AnimatedLetters
                              letterClass={letterClass}
                              strArray={nameArray}
                              idx={70}
                          />
                          {" "}
                          <AnimatedLetters
                              letterClass={letterClass}
                              strArray={jobArray}
                              idx={70}
                          />
                      </div>
                  </h1>

                  <h2 style={{ color: "blue" }}>Your home for everything Premier League related!</h2>
                  <Link to="/teams" className="flat-button">GET STARTED</Link>2
              </div>
          </div>
        <Loader type="pacman" />
      </>
    )
}

export default Home