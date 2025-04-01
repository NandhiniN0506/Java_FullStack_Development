import { Button, ButtonGroup, Box } from "@chakra-ui/react";

const Pagination = ({
  totalPages,
  currentPage,
  onPageChange,
}: {
  totalPages: number;
  currentPage: number;
  onPageChange: (page: number) => void;
}) => {
  return (
    <Box display="flex" justifyContent="center" alignItems="center" mt={4}>
      <ButtonGroup isAttached variant="outline">
        <Button isDisabled={currentPage === 1} onClick={() => onPageChange(currentPage - 1)}>
          Prev
        </Button>
        {[...Array(totalPages)].map((_, index) => (
          <Button
            key={index}
            onClick={() => onPageChange(index + 1)}
            colorScheme={currentPage === index + 1 ? "teal" : "gray"}
          >
            {index + 1}
          </Button>
        ))}
        <Button isDisabled={currentPage === totalPages} onClick={() => onPageChange(currentPage + 1)}>
          Next
        </Button>
      </ButtonGroup>
    </Box>
  );
};

export default Pagination;
