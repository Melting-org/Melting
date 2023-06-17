import React from 'react';
import { View, TextInput, TouchableOpacity, Text, StyleSheet, Image } from 'react-native';
import axios from 'axios';

const Register = ({ navigation }) => {
  const handleRegister = () => {
    const [memberid, setMemberid] = useState('');
    const [memberpwd, setMemberpwd] = useState('');
    const [membername, setMembername] = useState('');

    // const handleRegister = () => {
    // 회원가입 요청을 서버로 보내는 코드
    axios.post('http://localhost:5555/melting/', {
      memberid: memberid,
      memberpwd: memberpwd,
      membername: membername
    })
      .then(response => {
        console.log('회원가입 성공');
        navigation.navigate('Login');
      })
      .catch(error => {
        console.log('회원가입 실패:', error);
        // 필요한 에러 처리 수행
      });
  // };
    
  };

  const handleKakaoRegister = () => {
    // 카카오 로그인 로직 구현
  };

  const handleLogin = () => {
    navigation.navigate('Login');
  };

  return (
    <View style={styles.container}>
        <Image source={require('../../assets/logo.png')} style={styles.logo} />
        <TextInput 
            style={styles.input}
            placeholder="닉네임"
            placeholderTextColor="#757575" // 플레이스홀더 텍스트 색상
            fontSize={16}
            value={membername}
            onChangeText={text => setMembername(text)}
        />
        <TextInput 
            style={styles.input}
            placeholder="이메일"
            placeholderTextColor="#757575" // 플레이스홀더 텍스트 색상
            fontSize={16}
            value={memberid}
            onChangeText={text => setMemberid(text)}
        />
        <TextInput 
            style={styles.input}
            placeholder="비밀번호"
            secureTextEntry={true}
            placeholderTextColor="#757575" // 플레이스홀더 텍스트 색상
            fontSize={16}
            value={memberpwd}
            onChangeText={text => setMemberpwd(text)}
        />       
        <TouchableOpacity style={styles.button} onPress={handleRegister}>
            <Text style={styles.buttonText}>회원가입</Text>
        </TouchableOpacity>

        <View style={styles.line}></View>

        <TouchableOpacity style={styles.kakao} onPress={handleKakaoRegister}>
            <View style={styles.kakaoIconContainer}>
                <Image source={require('../../assets/kakao.png')} style={styles.kakaoIcon} />
            </View>
            <View style={styles.kakaoContent}>
                <Text style={styles.kakaoText}>카카오톡으로 회원가입</Text>
            </View>
        </TouchableOpacity>

        <TouchableOpacity style={styles.loginContainer} onPress={handleLogin}>
            <Text style={styles.loginText}>로그인 화면으로 돌아가기</Text>
        </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center', // 수직 가운데 정렬
      alignItems: 'center', // 수평 가운데 정렬
      backgroundColor: '#161616', // 배경색 지정
    },
    logo: {
        width: 130,
        height: 130,
        marginBottom: 20,
    },
    input: {
        width: '90%', // 원하는 넓이 설정
        height: 45,
        borderWidth: 0, // 외곽선 없앰
        borderRadius: 30,
        marginBottom: 15,
        paddingHorizontal: 20,
        color: 'white',
        fontSize: 16,
        backgroundColor: '#484848'
      },
      button: {
        width: '90%',
        height: 45,
        borderRadius: 30,
        marginBottom: 15,
        backgroundColor: '#4E9CAF',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'white'
      },
      buttonText: {
        color: 'black',
        fontSize: 17,
      },
      line: {
        height: 0.5,
        width: '90%',
        backgroundColor: '#474747',
        marginBottom: 15,
      },
      kakao: {
        width: '90%',
        height: 45,
        borderRadius: 30,
        marginBottom: 15,
        backgroundColor: '#4E9CAF',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#FDDC3F',
        flexDirection: 'row',
        alignItems: 'center',
      },
      kakaoText: {
        color: '#3D1D1C',
        fontSize: 17,
      },
      loginContainer: {
        width: '90%',
        justifyContent: 'flex-end',
        alignItems: 'flex-end',
      },
      loginText: {
        color: 'white',
        fontSize: 12,
      },
      kakaoIconContainer: {
        marginRight: 10,
      },
      kakaoIcon: {
        width: 20,
        height: 20,
      },
  });

export default Register;
