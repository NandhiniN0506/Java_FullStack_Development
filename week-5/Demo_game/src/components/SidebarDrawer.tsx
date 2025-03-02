import { useEffect } from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate
import {
  Drawer,
  DrawerOverlay,
  DrawerContent,
  DrawerHeader,
  DrawerBody,
  List,
  ListItem,
  Button,
  useDisclosure,
} from "@chakra-ui/react";

function SidebarDrawer() {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const navigate = useNavigate(); // Hook for navigation

  useEffect(() => {
    const handleMouseMove = (event: MouseEvent) => {
      if (event.clientX < 50) {
        onOpen();
      }
    };

    window.addEventListener("mousemove", handleMouseMove);
    return () => window.removeEventListener("mousemove", handleMouseMove);
  }, [onOpen]);

  return (
    <>
      <Drawer isOpen={isOpen} placement="left" onClose={onClose}>
        <DrawerOverlay />
        <DrawerContent bg="gray.800" color="white">
          <DrawerHeader borderBottomWidth="1px">Menu</DrawerHeader>
          <DrawerBody>
            <List spacing={3}>
              <ListItem>
                <Button colorScheme="teal" variant="ghost" width="100%" onClick={() => navigate("/About")}>
                  About
                </Button>
              </ListItem>
              <ListItem>
                <Button colorScheme="teal" variant="ghost" width="100%" onClick={() => navigate("/Profile")}>
                  Profile
                </Button>
              </ListItem>
              <ListItem>
                <Button colorScheme="teal" variant="ghost" width="100%" onClick={() => navigate("/Settings")}>
                  Settings
                </Button>
              </ListItem>
              <ListItem>
                <Button colorScheme="teal" variant="ghost" width="100%" onClick={() => navigate("/Categories")}>
                  Categories
                </Button>
              </ListItem>
            </List>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    </>
  );
}

export default SidebarDrawer;
