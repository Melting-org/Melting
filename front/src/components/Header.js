import React from "react";
import { View, Text, StyleSheet, SafeAreaView, Image } from "react-native";

const Header = () => {
  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={styles.container}>
        <Image style={styles.hamImg} source={require('../../assets/ham.png')} />
        <Text style={styles.title}>HOT</Text>
        <Image style={styles.magImg} source={require('../../assets/mag.png')} />
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  safeArea: {
    backgroundColor: '#161616', // 배경색 지정
  },
  container: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingVertical: 20,
    justifyContent: 'space-between', // 수직 가운데 정렬
  },
  hamImg: {
    width: 25,
    height: 20,
    marginLeft: 20, // 왼쪽 여백 추가
  },
  title: {
    color: "white",
    fontSize: 18,
    textAlign: "center",
    fontWeight: "bold",
  },
  magImg: {
    width: 25,
    height: 30,
    marginRight: 20, // 오른쪽 여백 추가
  },
});

export default Header;
