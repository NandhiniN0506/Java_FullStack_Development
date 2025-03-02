import React from 'react';
import { Box, Heading, Text, VStack } from '@chakra-ui/react';

const About = () => {
  return (
    <Box p={5}>
      <Heading size="xl" mb={4}>About Our Platform</Heading>
      <VStack align="start" spacing={4}>
        <Text fontSize="lg">
          Welcome to **GameHub**, the ultimate destination for discovering and exploring games from all genres.
          Whether you're a casual player or a hardcore gamer, we provide a seamless experience with a vast
          collection of games, ratings, and recommendations.
        </Text>
        <Text fontSize="lg">
          Our platform is powered by **RAWG API**, ensuring that you get the latest and most accurate data on
          games, including their ratings, reviews, and availability across platforms like PC, PlayStation,
          Xbox, and more.
        </Text>
        <Text fontSize="lg">
          We strive to enhance your gaming experience by offering personalized recommendations, daily streak rewards, 
          and an intuitive interface for easy navigation.
        </Text>
      </VStack>
    </Box>
  );
};

export default About;
