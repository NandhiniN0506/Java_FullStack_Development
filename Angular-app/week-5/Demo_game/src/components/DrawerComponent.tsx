import React, { useState } from 'react';
import {
  Drawer,
  DrawerBody,
  DrawerHeader,
  DrawerOverlay,
  DrawerContent,
  Button,
  Input,
  FormControl,
  FormLabel,
  HStack,
  useDisclosure,
} from '@chakra-ui/react';

function DrawerComponent() {
  const {
    isOpen: isSignInOpen,
    onOpen: onSignInOpen,
    onClose: onSignInClose,
  } = useDisclosure();

  const {
    isOpen: isSignUpOpen,
    onOpen: onSignUpOpen,
    onClose: onSignUpClose,
  } = useDisclosure();

  const [signInData, setSignInData] = useState({ email: '', password: '' });
  const [signUpData, setSignUpData] = useState({ name: '', email: '', password: '' });

  const handleSignInChange = (e: { target: { name: any; value: any; }; }) => {
    setSignInData({ ...signInData, [e.target.name]: e.target.value });
  };

  const handleSignUpChange = (e: { target: { name: any; value: any; }; }) => {
    setSignUpData({ ...signUpData, [e.target.name]: e.target.value });
  };

  const handleSignInSubmit = () => {
    console.log('Signing In:', signInData);
  };

  const handleSignUpSubmit = () => {
    console.log('Signing Up:', signUpData);
  };

  return (
    <>
      {/* Buttons to open respective drawers */}
      <HStack position="absolute" right="10px" top="50px" spacing={4}>
        <Button colorScheme="blue" onClick={onSignInOpen}>
          Sign In
        </Button>
        <Button colorScheme="green" onClick={onSignUpOpen}>
          Sign Up
        </Button>
      </HStack>

      {/* Sign In Drawer */}
      <Drawer isOpen={isSignInOpen} placement="left" onClose={onSignInClose}>
        <DrawerOverlay />
        <DrawerContent>
          <DrawerHeader>Sign In</DrawerHeader>
          <DrawerBody>
            <FormControl>
              <FormLabel>Email</FormLabel>
              <Input name="email" type="email" value={signInData.email} onChange={handleSignInChange} />
            </FormControl>
            <FormControl mt={4}>
              <FormLabel>Password</FormLabel>
              <Input name="password" type="password" value={signInData.password} onChange={handleSignInChange} />
            </FormControl>
            <Button colorScheme="blue" mt={4} onClick={handleSignInSubmit}>
              Submit
            </Button>
          </DrawerBody>
        </DrawerContent>
      </Drawer>

      {/* Sign Up Drawer */}
      <Drawer isOpen={isSignUpOpen} placement="left" onClose={onSignUpClose}>
        <DrawerOverlay />
        <DrawerContent>
          <DrawerHeader>Sign Up</DrawerHeader>
          <DrawerBody>
            <FormControl>
              <FormLabel>Name</FormLabel>
              <Input name="name" type="text" value={signUpData.name} onChange={handleSignUpChange} />
            </FormControl>
            <FormControl mt={4}>
              <FormLabel>Email</FormLabel>
              <Input name="email" type="email" value={signUpData.email} onChange={handleSignUpChange} />
            </FormControl>
            <FormControl mt={4}>
              <FormLabel>Password</FormLabel>
              <Input name="password" type="password" value={signUpData.password} onChange={handleSignUpChange} />
            </FormControl>
            <Button colorScheme="green" mt={4} onClick={handleSignUpSubmit}>
              Submit
            </Button>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    </>
  );
}

export default DrawerComponent;