import React from 'react';
import { Box, Heading, VStack, Switch, FormControl, FormLabel, Divider } from '@chakra-ui/react';

const Settings = () => {
  return (
    <Box p={5}>
      <Heading size="xl" mb={4}>Settings</Heading>
      <VStack align="start" spacing={4}>
        
        <Heading size="md">🔧 General</Heading>
        <FormControl display="flex" alignItems="center">
          <FormLabel mb="0">Enable Dark Mode</FormLabel>
          <Switch colorScheme="teal" />
        </FormControl>

        <FormControl display="flex" alignItems="center">
          <FormLabel mb="0">Receive Notifications</FormLabel>
          <Switch colorScheme="teal" />
        </FormControl>

        <Divider />

        <Heading size="md">🔐 Privacy & Security</Heading>
        <FormControl display="flex" alignItems="center">
          <FormLabel mb="0">Two-Factor Authentication</FormLabel>
          <Switch colorScheme="red" />
        </FormControl>

        <FormControl display="flex" alignItems="center">
          <FormLabel mb="0">Make Profile Public</FormLabel>
          <Switch colorScheme="red" />
        </FormControl>

      </VStack>
    </Box>
  );
};

export default Settings;
