import React from 'react';
import { Box, Heading, Text, VStack } from '@chakra-ui/react';

const Categories = () => {
  return (
    <Box p={5}>
      <Heading size="xl" mb={4}>Game Categories</Heading>
      <VStack align="start" spacing={4}>
        <Heading size="md">🎭 Action</Heading>
        <Text fontSize="md">
          Fast-paced games with intense combat and thrilling gameplay. Popular examples include **Call of Duty, 
          Assassin's Creed, and Doom**.
        </Text>

        <Heading size="md">🧩 Puzzle</Heading>
        <Text fontSize="md">
          Challenge your mind with logic-based games like **Tetris, Portal, and The Witness**.
        </Text>

        <Heading size="md">⚽ Sports</Heading>
        <Text fontSize="md">
          Experience realistic sports simulations like **FIFA, NBA 2K, and Madden NFL**.
        </Text>

        <Heading size="md">🗡️ RPG</Heading>
        <Text fontSize="md">
          Embark on epic adventures with deep storytelling in games like **The Witcher, Final Fantasy, and Skyrim**.
        </Text>
      </VStack>
    </Box>
  );
};

export default Categories;
