import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import { Grid, GridItem } from '@chakra-ui/react'
import Navbar  from './components/Navbar'
import GameCard from './components/GameCard'
import DrawerComponent from './components/DrawerComponent'
import StreakTracker from './components/StreakTracker'
import SidebarDrawer from './components/SidebarDrawer'


function App() {
  return (
    <div className="appcss">
      <Grid
        templateAreas={`"nav nav" "main main"`}
        templateRows={"auto 1fr"}
        templateColumns={"250px 1fr"} // Ensure side panel width
        height="100vh"
      >
        {/* Navigation Bar */}
        <GridItem area={"nav"} bg={"palegoldenrod"}>
          <StreakTracker/>
          <Navbar />
          <DrawerComponent/>
        </GridItem>

        {/* Sidebar (Fix for black space) */}
        <GridItem area={"side"} bg={"#1a202c"}> {/* Dark color for sidebar */}
          {/* Sidebar Content */}
          <SidebarDrawer />
        </GridItem>

        {/* Main Content */}
        <GridItem area={"main"} bg={"darkcyan"}>
          <GameCard />
        </GridItem>
      </Grid>
    </div>
  );
}

export default App;
