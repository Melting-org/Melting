import React, { useEffect, useRef, useState } from 'react';
import { View, TextInput, TouchableOpacity, Text, StyleSheet, Image, Animated } from 'react-native';
import LottieView from 'lottie-react-native';

const Login = ({ navigation }) => {
    const [animationLoaded, setAnimationLoaded] = useState(false);
    const fadeAnim = useRef(new Animated.Value(0)).current;

    const handleLogin = () => {
        // 로그인 로직 구현
    };

    const handleKakaoLogin = () => {
        // 카카오 로그인 로직 구현
    };

    const handleRegister = () => {
        navigation.navigate('Register');
    };

    useEffect(() => {
        // Lottie 애니메이션 로드가 완료되면 상태를 업데이트하여 다른 항목을 나타내도록 함
        const animation = require('../../assets/melting.json');
        setAnimationLoaded(true);
    }, []);

    useEffect(() => {
        if (!animationLoaded) {
            Animated.timing(fadeAnim, {
                toValue: 1,
                duration: 1000,
                useNativeDriver: true,
            }).start();
        }
    }, [animationLoaded, fadeAnim]);

    return (
        <View style={styles.container}>
            {animationLoaded ? (
                // Lottie 애니메이션 로드가 완료된 경우
                <LottieView
                    source={require('../../assets/melting.json')}
                    autoPlay
                    loop={false}
                    onAnimationFinish={() => {
                        // 애니메이션이 끝나면 다른 항목들이 나타날 수 있도록 함
                        setAnimationLoaded(false);
                    }}
                />
            ) : (
                // Lottie 애니메이션 로드 중인 경우 다른 항목은 숨겨진 상태로
                <Animated.View style={[styles.anim, { opacity: fadeAnim }]}>
                    <Image source={require('../../assets/logo.png')} style={styles.logo} />
                    <TextInput
                        style={styles.input}
                        placeholder="이메일"
                        placeholderTextColor="#757575" // 플레이스홀더 텍스트 색상
                        fontSize={16}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder="비밀번호"
                        secureTextEntry={true}
                        placeholderTextColor="#757575" // 플레이스홀더 텍스트 색상
                        fontSize={16}
                    />
                    <TouchableOpacity style={styles.button} onPress={handleLogin}>
                        <Text style={styles.buttonText}>로그인</Text>
                    </TouchableOpacity>

                    <View style={styles.line}></View>

                    <TouchableOpacity style={styles.kakao} onPress={handleKakaoLogin}>
                        <View style={styles.kakaoIconContainer}>
                            <Image source={require('../../assets/kakao.png')} style={styles.kakaoIcon} />
                        </View>
                        <View style={styles.kakaoContent}>
                            <Text style={styles.kakaoText}>카카오톡으로 로그인</Text>
                        </View>
                    </TouchableOpacity>

                    <TouchableOpacity style={styles.loginContainer} onPress={handleRegister}>
                        <Text style={styles.loginText}>아직 멜팅 계정이 없으신가요?</Text>
                    </TouchableOpacity>
                </Animated.View>
            )}
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
    anim: {
        flex: 1,
        justifyContent: 'center', // 수직 가운데 정렬
        alignItems: 'center', // 수평 가운데 정렬
        width: '100%',
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
        backgroundColor: '#484848',
    },
    button: {
        width: '90%',
        height: 45,
        borderRadius: 30,
        marginBottom: 15,
        backgroundColor: '#4E9CAF',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'white',
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

export default Login;
