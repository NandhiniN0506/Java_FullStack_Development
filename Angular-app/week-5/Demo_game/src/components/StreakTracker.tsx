import React, { useEffect, useState } from 'react';
import { Box, Text, HStack, Icon } from '@chakra-ui/react';
import { FaFire } from 'react-icons/fa';

const StreakTracker = () => {
  const [streak, setStreak] = useState<number>(0);

  useEffect(() => {
    const lastLogin = localStorage.getItem('lastLoginDate');
    const currentDate = new Date().toDateString();

    if (lastLogin === currentDate) {
      return; // Already logged in today
    }

    const previousDate = new Date();
    previousDate.setDate(previousDate.getDate() - 1);

    if (lastLogin === previousDate.toDateString()) {
      setStreak((prevStreak) => prevStreak + 1);
      localStorage.setItem('streak', String(streak + 1));
    } else {
      setStreak(1);
      localStorage.setItem('streak', '1'); // Reset streak
    }

    localStorage.setItem('lastLoginDate', currentDate);
  }, []);

  return (
    <Box p={4} display="flex" alignItems="center">
      <HStack spacing={2}>
        <Icon as={FaFire} color="orange.400" boxSize={6} />
        <Text fontSize="lg" fontWeight="bold" color="gray.700">
          {streak} Day Login Streak
        </Text>
      </HStack>
    </Box>
  );
};

export default StreakTracker;
