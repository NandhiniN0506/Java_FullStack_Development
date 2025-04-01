import React from 'react';
import { Box, Heading, Text, VStack, Avatar, Divider } from '@chakra-ui/react';

const Profile = () => {
  return (
    <Box p={5}>
      <Heading size="xl" mb={4}>User Profile</Heading>
      <VStack align="start" spacing={4}>
        <Avatar size="xl" name="User Name" src="https://via.placeholder.com/150" />
        <Text fontSize="lg"><b>Username:</b> GamerX</Text>
        <Text fontSize="lg"><b>Email:</b> gamerx@example.com</Text>
        <Divider />
        <Heading size="md">Activity</Heading>
        <Text>🎮 Games Played: 24</Text>
        <Text>🏆 Achievements Unlocked: 12</Text>
        <Text>🔥 Daily Login Streak: 7 Days</Text>
      </VStack>
    </Box>
  );
};

export default Profile;
