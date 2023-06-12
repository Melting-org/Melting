import React from "react";
import { View, Text, StyleSheet, SafeAreaView } from "react-native";

const Header = () => {
  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Text style={styles.title}>HOT</Text>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  safeArea: {
    backgroundColor: '#161616', // 배경색 지정
  },
  container: {
    paddingVertical: 20,
    justifyContent: 'center', // 수직 가운데 정렬
  },
  title: {
    color: "white",
    fontSize: 18,
    textAlign: "center",
    fontWeight: "bold",
  },
});

export default Header;
