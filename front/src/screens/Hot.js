import React, { useState } from 'react';
import { View, ScrollView, TouchableOpacity, Text, StyleSheet, Image } from 'react-native';
import RNPickerSelect from 'react-native-picker-select';

const Hot = () => {

  // RNPickerSelect 기본값을 '추천순'으로 설정.
  const [selectedSort, setSelectedSort] = useState('추천순');

  return (
    <View style={styles.container}>
      <View style={styles.flexContainer}>
        <Image style={styles.arrow} source={require('../../assets/arrow.png')} />
        <RNPickerSelect
          textInputProps={{ 
            style: {
              fontSize: 13,
              marginRight: 10,
              // backgroundColor: 'blue', // 추천순 배경
              alignItems: 'center',
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
        {/* <Image style={styles.bigImg} source={require('../../assets/small.png')} /> */}
      </View>
      <ScrollView style={styles.postsContainer}>
        {/* 게시글 */}
        <TouchableOpacity style={styles.postItem}>
          <Image style={styles.thumbnail} source={require('../../assets/thumbnail.jpg')} />
          <View style={styles.postContent}>
            <Text style={styles.postTitle}>멜팅 프로젝트의 게시물의 제목</Text>
            <View style={styles.postDetails}>
              <Text style={styles.detail1}>커뮤니티이름</Text>
              {/* <Text style={styles.detail2}>23.06.14</Text> */}
            </View>
            <View style={styles.reactions}>
            <Text style={styles.like}>💗50</Text>
            <Text style={styles.comment}>💬30</Text>
            </View>
          </View>
        </TouchableOpacity>
        {/* TouchableOpacity가 반복되면 게시글 반복 */}
        <View style={styles.line}></View>
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
    paddingHorizontal: 16, // 오른쪽
    marginTop: 10,
    // backgroundColor: 'red' // 상단 배경
  },
  arrow: {
    width: 9,
    height: 12,
    marginRight: 5
  },
  title: {
    fontSize: 16,
    fontWeight: 'bold',
    textAlign: 'center', // Vertically center align the title
    flex: 1,
  },
  bigImg: {
    width: 13,
    height: 13,
  },
  postsContainer: {
    paddingHorizontal: 16,
    marginTop: 10, // flexcontainer, postcontainer 사이 여백
  },
  postItem: {
    flexDirection: 'row',
    marginBottom: 10,
    // backgroundColor: 'green', // thumnail 이미지 배경
    paddingBottom: 10,
  },
  thumbnail: {
    width: 120,
    height: 120,
    borderRadius: 10
  },
  postContent: {
    flex: 1,
    paddingLeft: 15,
    justifyContent: 'center', // 수직 가운데 정렬
    // backgroundColor: 'yellow' // thumnail 옆 게시글 관련 배경
  },
  postTitle: {
    fontSize: 18,
    padding: 0,
    fontWeight: 'bold',
  },
  postDetails: {
    flexDirection: 'row',
    // justifyContent: 'space-between',
    alignItems: 'center',
    marginTop: 5,
  },
  detail1: {
    fontSize: 12,
    width: 100,
    color: '#818181'
    // backgroundColor: 'purple',
  },
  detail2: {
    fontSize: 12,
    color: '#818181'
  },
  reactions: {
    flexDirection: 'row',
    marginTop: 40,

  },
  like: {
    fontSize: 12,
    width: 50,
  },
  comment: {
    fontSize: 12,
  },
  line: {
    borderBottomColor: '#D9D9D9',
    borderBottomWidth: 1,
  }
});

export default Hot;
