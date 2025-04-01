import React, { useEffect, useState } from "react";
import { Box, Image, Text, Spinner, Grid, GridItem, Link, HStack } from "@chakra-ui/react";
import { FaStar, FaRegStar } from "react-icons/fa";
import axios from "axios";
import Pagination from "./Pagination"; // ✅ Import pagination

const API_KEY = "2fb76c1996c642ee8debdf7e0df8a9eb";
const API_URL = `https://api.rawg.io/api/games?key=${API_KEY}&page=`;

// ✅ Define TypeScript interface for game data
interface Game {
  id: number;
  name: string;
  background_image: string;
  rating: number;
}

function GameCard() {
  const [games, setGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState(true);
  const [currentPage, setCurrentPage] = useState(1);
  const totalPages = 5; // 🔹 Adjust based on API limits

  useEffect(() => {
    setLoading(true);
    axios
      .get<{ results: Game[] }>(`${API_URL}${currentPage}`)
      .then((response) => {
        setGames(response.data.results);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching games:", error);
        setLoading(false);
      });
  }, [currentPage]); // 🔹 Fetch games whenever page changes

  if (loading) {
    return <Spinner size="xl" />;
  }

  // ⭐ Function to render star ratings
  const renderStars = (rating: number) => {
    const totalStars = 5;
    const filledStars = Math.round(rating);
    return (
      <HStack>
        {[...Array(totalStars)].map((_, index) =>
          index < filledStars ? <FaStar key={index} color="gold" /> : <FaRegStar key={index} color="gray" />
        )}
      </HStack>
    );
  };

  return (
    <Box>
      <Grid templateColumns="repeat(auto-fit, minmax(250px, 1fr))" gap={6} p={4}>
        {games.map((game) => (
          <GridItem key={game.id} borderWidth="1px" borderRadius="lg" overflow="hidden" boxShadow="md">
            <Link href={`https://play.google.com/store/search?q=${encodeURIComponent(game.name)}&c=apps`} isExternal>
              <Image src={game.background_image} alt={game.name} />
            </Link>
            <Box p="4">
              <Text fontSize="xl" fontWeight="bold">{game.name}</Text>
              {renderStars(game.rating)}
            </Box>
          </GridItem>
        ))}
      </Grid>

      {/* ✅ Add Pagination Below */}
      <Pagination totalPages={totalPages} currentPage={currentPage} onPageChange={setCurrentPage} />
    </Box>
  );
}

export default GameCard;
