import "react-native-gesture-handler";
import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
// createStackNavigator는 Screen과 Navigator 두 가지 속성을 포함하는 객체를 반환하는 함수

import Login from "./src/screens/Login";
import Register from "./src/screens/Register";
import Hot from "./src/screens/Hot";
import Header from "./src/components/Header";

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator
      initialRouteName="Hot"
      screenOptions={{
        animationEnabled: false, // 전환 애니메이션 비활성화
      }}>
        {/* initialRouteName에 기본적으로 렌더링할 화면을 등록 */}
        <Stack.Screen
            name="HOT" // 헤더 문구
            component={Hot}
            options={{
              header: () => <Header />, // Hot.js에만 헤더 적용
            }}
          />

        <Stack.Screen
          name="Login"
          component={Login}
          options={{ headerShown: false }} // 헤더 숨김
         />
        <Stack.Screen
          name="Register"
          component={Register}
          options={{ headerShown: false }} // 헤더 숨김
         />
         
      </Stack.Navigator>
    </NavigationContainer>
  );
}