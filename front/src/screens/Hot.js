import React, { useState } from 'react';
import { View, ScrollView, TouchableOpacity, Text, StyleSheet, Image } from 'react-native';
import RNPickerSelect from 'react-native-picker-select';

const Hot = ({ navigation }) => {

  // RNPickerSelect 기본값을 '추천순'으로 설정.
  const [selectedSort, setSelectedSort] = useState('추천순');

  return (
    <View style={styles.container}>
      <View style={styles.flexContainer}>
        <RNPickerSelect
          textInputProps={{ 
            style: {
              fontSize: 16,
            },
            underlineColorAndroid: 'transparent' }}
          onValueChange={(value) => setSelectedSort(value)}
          value={selectedSort} // 기본값으로 selectSort 사용
          useNativeAndroidPickerStyle={false}
          placeholder={{ label: '추천순', value: '추천순' }}
          items={[
              { label: '댓글순', value: '댓글순' },
          ]}
        />
        <Image style={styles.bigImg} source={require('../../assets/big.png')} />
      </View>
      <ScrollView style={styles.postsContainer}>
        {/* 게시글 */}
        <TouchableOpacity style={styles.postItem}>
          <Image style={styles.thumbnail} source={require('../../assets/thumbnail.jpg')} />
          <View style={styles.postContent}>
            <Text style={styles.postTitle}>게시글 제목</Text>
            <View style={styles.postDetails}>
              <Text style={styles.postInfo}>커뮤니티</Text>
              <Text style={styles.postInfo}>날짜</Text>
            </View>
            <Text style={styles.postStats}>50 30</Text>
          </View>
        </TouchableOpacity>
        {/* TouchableOpacity가 반복되면 게시글 반복 */}
        
      </ScrollView>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
  },
  flexContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'flex-end',
    paddingHorizontal: 16,
    paddingVertical: 10,
    height: 50,
  },
  title: {
    fontSize: 16,
    fontWeight: 'bold',
    textAlign: 'center', // Vertically center align the title
    flex: 1,
  },
  bigImg: {
    width: 16,
    height: 16,
  },
  postsContainer: {
    paddingHorizontal: 16,
    marginTop: 10,
  },
  postItem: {
    flexDirection: 'row',
    height: 50,
    marginBottom: 10,
    backgroundColor: '#ffffff',
  },
  thumbnail: {
    width: 50,
    height: 50,
  },
  postContent: {
    flex: 1,
    paddingLeft: 10,
    justifyContent: 'center',
  },
  postTitle: {
    fontSize: 14,
    fontWeight: 'bold',
  },
  postDetails: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginTop: 2,
  },
  postInfo: {
    fontSize: 12,
  },
  postStats: {
    fontSize: 12,
    marginTop: 2,
    marginLeft: 10,
  },
});

export default Hot;
