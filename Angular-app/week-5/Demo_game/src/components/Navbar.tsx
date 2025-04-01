import { HStack, Image ,Text} from '@chakra-ui/react';
import logo from '../assets/logo.png'
import SwitchDark from './SwitchDark';
import React from 'react';

function Navbar() {
     return (
        <HStack justifyContent={'space-between'} padding={'20px'}>
        <Image src = {logo} boxSize={"90px"}></Image>
        <Text as = "b" fontSize={70} colorScheme='blue'>GameSphere</Text>
        <SwitchDark/>
      </HStack>//horizontal stack
     );
}

export default Navbar;