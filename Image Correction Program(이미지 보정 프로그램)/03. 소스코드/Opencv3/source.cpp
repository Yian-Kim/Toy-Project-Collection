#include <stdio.h>
#include <opencv/cv.h> // 영상 처리를 위한 header
#include <opencv/highgui.h> // 이미지를 읽어들이고 화면에 보여주기
#include "opencv2/highgui/highgui.hpp""
#include "opencv2/imgproc/imgproc.hpp"

void gaussian(); // 가우시안
void bilateral(); // 바이라테랄
void erosion(); // 침식
void pencilsketch(); // 연필스케치

using namespace cv;
using namespace std;

int main(int argc, char** argv)
{
	int select = 0;

	printf("==== 필터선택 ==== \n1. Gaussian filter \n2. Bilateral filter \n3. Erosion filter \n4. Pencil sketch filter \n선택 : ");
	scanf_s("\n%d", &select, 1); // 사용자로부터 선택입력받기

	switch (select)
	{
	case 1:
		gaussian(); // 가우시안
		break;
	case 2:
		bilateral(); // 바이라테랄
		break;
	case 3:
		erosion(); // 침식
		break;
	case 4:
		pencilsketch(); // 연필스케치
		break;
	default:
		printf("Error");
		break;
	}
}

void gaussian() // 가우시안
{
	IplImage* img = cvLoadImage("redhair.jpg"); // 이미지 불러오기

	// cvCreateImage : IplImage 구조체의 메모리를 생성하여 그 포인터를 넘겨준다.
	// (이미지 크기, 비트의 크기, 채널 갯수)
	// cvGetSize 함수를 이용하여 IplImage 이미지의 크기를 얻어와서
	// 비트의 크기를 구하고 
	//  Gray 이미지는 1채널, RGB 이미지는 3채널이므로 1로 설정
	IplImage* input = cvCreateImage(cvGetSize(img), img->depth, 3);
	IplImage* output = cvCreateImage(cvGetSize(img), img->depth, 3);

	// 윈도우 생성
	cvNamedWindow("Original", CV_WINDOW_AUTOSIZE);
	cvNamedWindow("Gaussian filter", CV_WINDOW_AUTOSIZE);

	// cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	// ("제목", 출력영상)
	cvShowImage("Original", img); // 윈도우에 이미지 나타내기

	cvSmooth(img, output, CV_GAUSSIAN, 21, 21, 0, 0); // 'img'를 가우시안 효과로 'output'에 저장

	// cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	 // ("제목", 출력영상)
	cvShowImage("Gaussian filter", output); // "Output" 윈도우에 img2를 보여주기

	// cvWaitKey : 프로그램의 동작을 멈추고 사용자로부터 키 입력을 기다리는 함수
	// 키보드 입력을 무한정 기다림
	waitKey(0);

	 // cvReleaseImage : 할당된 메모리 공간을 해제하는 함수
	 // 이미지 메모리 해제
	cvReleaseImage(&img);

	// 모든 윈도우 종료
	cvDestroyWindow("Original");
	cvDestroyWindow("Gaussian filter");

}

void bilateral() // 바이라테랄
{
	// n-차원 밀집형 배열 클래스 Mat 변수 선언
	Mat image, dst;
	image = imread("redhair.jpg", CV_LOAD_IMAGE_COLOR);

	// bilateralFilter : 엣지와 노이즈를 줄여주어 부드러운 영상이 되게 한다.
	// (입력영상, 출력영상, 필터링에 이용하는 픽셀의 지름, 컬러공간의 시그마 공간 정의, 시그마 필터 조정)
	// 필터링에 이용하는 픽셀의 지름을 정의 불가능한 경우 sigmaSpace 사용
	// 컬러공간의 시그마 공간 정의는 클수록 이웃한 픽셀과 기준 색상의 영향이 커진다.
	// 시그마 필터 조정값이 클수록 긴밀하게 주변 픽셀에 영향을 미친다. d>0은 영향없고, 다른 경우는 d에 비례
	bilateralFilter(image, dst, 15, 80, 80);

	// imshow : 영상을 출력하는 함수
	// ("제목", 출력영상)
	imshow("Original", image);
	imshow("Bilateral filter", dst);

	waitKey(0);
}

void erosion() // 침식
{
	IplImage* img = cvLoadImage("redhair.jpg"); // 이미지 불러오기

	// cvCreateImage : IplImage 구조체의 메모리를 생성하여 그 포인터를 넘겨준다.
	// (이미지 크기, 비트의 크기, 채널 갯수)
	IplImage* dst = cvCreateImage(cvGetSize(img), IPL_DEPTH_8U, 3);

	// 윈도우 생성
	cvNamedWindow("Original", CV_WINDOW_AUTOSIZE);
	cvNamedWindow("Erosion filter", CV_WINDOW_AUTOSIZE);

	// cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	// ("제목", 출력영상)
	cvShowImage("Original", img); // 윈도우에 이미지 나타내기

	// cvErode : 침식, 이미지를 약화시키는 작업을 하는 함수
	// (입력영상, 출력영상, 임의의 구조화(0또는 NULL이면 정사각형 형태), 반복횟수)
	cvDilate(img, dst);

	cvShowImage("Erosion filter", dst); // "Output" 윈도우에 img2를 보여주기
	
	// cvWaitKey : 프로그램의 동작을 멈추고 사용자로부터 키 입력을 기다리는 함수
	// 키보드 입력을 무한정 기다림
	waitKey(0);

	// cvReleaseImage : 할당된 메모리 공간을 해제하는 함수
	// 이미지 메모리 해제
	cvReleaseImage(&img);

	// 모든 윈도우 종료
	cvDestroyWindow("Original");
	cvDestroyWindow("Erosion filter");

}

void pencilsketch() // 연필스케치
{

	IplImage* img = cvLoadImage("redhair.jpg"); // 이미지 불러오기

	// cvCreateImage : IplImage 구조체의 메모리를 생성하여 그 포인터를 넘겨준다.
	// (이미지 크기, 비트의 크기, 채널 갯수)
	// cvGetSize 함수를 이용하여 IplImage 이미지의 크기를 얻어와서
	// 비트의 크기를 구하고 
	//  Gray 이미지는 1채널, RGB 이미지는 3채널이므로 1로 설정
	IplImage* img1 = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* img2 = cvCreateImage(cvGetSize(img), img->depth, 1);
	//IplImage* dst = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* gray = cvCreateImage(cvGetSize(img), img->depth, 1);

	// ((가로,세로 길이), 비트의 크기, 채널 갯수)
	// 특정 이미지의 채널 갯수를 맞추기 위해 image->nChannels 사용
	//IplImage* temp = cvCreateImage(cvSize(img->width, img->height), img->depth, img->nChannels);
	//IplImage* result = cvCreateImage(cvSize(img->width, img->height), img->depth, img->nChannels);

	// 윈도우 생성
	cvNamedWindow("Original", CV_WINDOW_AUTOSIZE);
	cvNamedWindow("Pencil sketch filter", CV_WINDOW_AUTOSIZE);

	// cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	// ("제목", 출력영상)
	cvShowImage("Original", img); // 윈도우에 이미지 나타내기

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
	cvCvtColor(img, gray, CV_RGB2GRAY); // RGB 'img'를 Gray로 바꾸어서 'gray'에 저장

	//  cvSmooth : noise 또는 손상을 완화하는 함수
	// (입력영상, 출력영상, smoothing 방법, smothtype에 따라 달라짐)
	/*
				param1, param2 : 필터 윈도우의 가로와 세로 크기
				param3(선택) : 커널의 시그마값(표준편차)
				param4(선택) : 세로 방향의 시그마값, 이때 prama3는 가로 방향의 시그마값
	*/
	cvSmooth(gray, img1, CV_GAUSSIAN, 21, 21, 0, 0); // 'gray'를 가우시안 효과로 'img1'에 저장

	 // cvDiv : 사칙연산 중 나눗셈 함수
	 // (나눗셈 연산할 첫 번째 배열, 나눗셈 연산할 두 번째 배열, 연산 결과 저장할 배열, scaling을 위한 상수)
	 // img2 = gray / img1 * 256)
	cvDiv(gray, img1, img2, 256); // gray와 img1을 나누고 결과를 img2에 저장, scale 256만큼 곱하기

	 // cvShowImage : 해당 제목을 가진 영상을 윈도우에 출력하는 함수
	 // ("제목", 출력영상)
	cvShowImage("Pencil sketch filter", img2); // "Output" 윈도우에 img2를 보여주기

	 // cvWaitKey : 프로그램의 동작을 멈추고 사용자로부터 키 입력을 기다리는 함수
	 // 키보드 입력을 무한정 기다림
	cvWaitKey(0);

	// cvReleaseImage : 할당된 메모리 공간을 해제하는 함수
	// 이미지 메모리 해제
	cvReleaseImage(&img);

	// 모든 윈도우 종료
	cvDestroyWindow("Original");
	cvDestroyWindow("Pencil sketch filter");
}