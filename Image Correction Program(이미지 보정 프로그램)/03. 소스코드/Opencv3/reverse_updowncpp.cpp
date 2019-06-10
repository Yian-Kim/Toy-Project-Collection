/*

// 추가발표

#include <opencv/cv.h> // 영상 처리를 위한 header
#include <opencv/highgui.h> // 카메라로 영상을 입력받거나 이미지를 읽어들이고 화면에 보여주기
#include "opencv2/highgui/highgui.hpp""
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>

using namespace cv;
using namespace std;

int main(int argc, char** argv)
{
	IplImage* img = cvLoadImage("cat.jpg"); // 이미지 불러오기

	// cvCreateImage : IplImage 구조체의 메모리를 생성하여 그 포인터를 넘겨준다.
	// (이미지 크기, 비트의 크기, 채널 갯수)
	// cvGetSize 함수를 이용하여 IplImage 이미지의 크기를 얻어와서
	// 
	//  Gray 이미지는 1채널, RGB 이미지는 3채널이므로 1로 설정
	// 사본 이미지의 크기 설정
	IplImage* img1 = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* img2 = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* dst = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* gray = cvCreateImage(cvGetSize(img), img->depth, 1);

	// ((가로,세로 길이), 비트의 크기, 채널 갯수)
	// 특정 이미지의 채널 갯수를 맞추기 위해 image->nChannels 사용
	IplImage* temp = cvCreateImage(cvSize(img->width, img->height), img->depth, img->nChannels);
	IplImage* result = cvCreateImage(cvSize(img->width, img->height), img->depth, img->nChannels);
	
	Mat image, dst1, dst2, dst3;
	image = imread("redhair.jpg", CV_LOAD_IMAGE_COLOR);

	// Create a structuring element(erosion)
	int erosion_size = 6;
	Mat element = getStructuringElement(cv::MORPH_CROSS,
		cv::Size(2 * erosion_size + 1, 2 * erosion_size + 1),
		cv::Point(erosion_size, erosion_size));

	// 윈도우 생성
	cvNamedWindow("Input", CV_WINDOW_AUTOSIZE);
	cvNamedWindow("Output", CV_WINDOW_AUTOSIZE);

	// cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	// ("제목", 출력영상)
	cvShowImage("Input", img); // 윈도우에 이미지 나타내기

	// cvCvtColor : 컬러를 흑백으로 변환
	// (입력영상, 출력영상, 흑백으로 변환)
	/* 
		CV_RGB2GRAY : 흑백으로 변환
		CV_RGB2YCrCb : Skin Color 모델할 때 변환(손 제스쳐 인식, 얼굴 인식)
		CV_RGB2HLS
		CV_RGB2HSV
		CV_RGB2Lab
		CV_RGB2Luv
	*/
/*
	cvCvtColor(img, gray, CV_RGB2GRAY); // RGB 'img'를 Gray로 바꾸어서 'gray'에 저장
	
	//  cvSmooth : noise 또는 손상을 완화하는 함수
	// (입력영상, 출력영상, smoothing 방법, smothtype에 따라 달라짐)
	/*
		param1, param2 : 필터 윈도우의 가로와 세로 크기
		param3(선택) : 커널의 시그마값(표준편차)
		param4(선택) : 세로 방향의 시그마값, 이때 prama3는 가로 방향의 시그마값
	*/
	/*
	cvSmooth(gray, img1, CV_GAUSSIAN, 21, 21, 0, 0); // 'gray'를 가우시안 효과로 'img1'에 저장

	// cvDiv : 사칙연산 중 나눗셈 함수
	// (나눗셈 연산할 첫 번째 배열, 나눗셈 연산할 두 번째 배열, 연산 결과 저장할 배열, scaling을 위한 상수)
	// img2 = gray / img1 * 256)
	cvDiv(gray, img1, img2, 256); // gray와 img1을 나누고 결과를 img2에 저장, scale 256만큼 곱하기

	 //  ==== Apply erosion or dilation on the image ==== 
	erode(image, dst1, element);

	// ==== Apply bilateral filter ==== 
	bilateralFilter(image, dst2, 15, 80, 80);

	//  ====  Apply Smoothing (Blurring) by Gaussian  ==== 

	for (int i = 1; i < 51; i = i + 2)
	{
		// Gaussian smoothing
		GaussianBlur(image, dst3, Size(i, i), 0, 0);
	}
	//  ====  end of Smoothing (Blurring) by Gaussian  ====  
	

	// cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	// ("제목", 출력영상)
	cvShowImage("Output", img2); // "Output" 윈도우에 img2를 보여주기

	imshow("Gaussian filter", dst3);
	imshow("Original", image);
	imshow("Erosion filter", dst1);
	imshow("Bilateral filter", dst2);

	// cvWaitKey : 프로그램의 동작을 멈추고 사용자로부터 키 입력을 기다리는 함수
	// 키보드 입력을 무한정 기다림
	cvWaitKey(0);

	// cvReleaseImage : 할당된 메모리 공간을 해제하는 함수
	// 이미지 메모리 해제
	cvReleaseImage(&img); 

	// 모든 윈도우 종료
	cvDestroyWindow("Input");
	cvDestroyWindow("Output");

	return 0;
}

*/