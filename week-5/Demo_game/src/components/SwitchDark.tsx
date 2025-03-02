import { Box, HStack, Switch, useColorMode } from "@chakra-ui/react";

function SwitchDark() {
 let {colorMode,toggleColorMode} = useColorMode();
  return <>
  <HStack>
    <Switch  
            colorScheme="purple"
            isChecked={colorMode == 'dark'}
            onChange={toggleColorMode}>
        Dark Mode
    </Switch>
  </HStack>
    </>
}

export default SwitchDark;