/*#include <opencv/cv.h>
#include <opencv/cxcore.h>
#include <opencv/cvaux.h>
#include <opencv/highgui.h>

void detect_and_draw(IplImage * img);

int main()
{
	CvCapture * capture = 0;
	IplImage *frame;

	capture = cvCaptureFromFile("KakaoTalk_Video_20151111_0506_13_161.mp4");

	cvNamedWindow("result", 1);

	if (!capture) {
		fprintf(stderr, "cannot capture");
	}


	for (;;)
	{
		frame = cvQueryFrame(capture);
		if (!frame)break;

		detect_and_draw(frame);

		if (cvWaitKey(3) >= 0) break;

	}

	cvReleaseCapture(&capture);

	cvDestroyWindow("result");

}

void detect_and_draw(IplImage * input) {


	IplImage  *output, *bilaFilter, *updata, *img_gray, *img_blur, *img_edge, *posedge, *result;

	output = cvCreateImage(cvSize(input->width / 2, input->height / 2), input->depth, input->nChannels);
	for (int i = 0; i < 2; i++)
		cvPyrDown(input, output);

	bilaFilter = cvCreateImage(cvGetSize(output), output->depth, 3);
	for (int i = 0; i < 7; i++)
		cvSmooth(output, bilaFilter, CV_BILATERAL, 3, 0, 2, 2);

	updata = cvCreateImage(cvSize(bilaFilter->width * 2, bilaFilter->height * 2), bilaFilter->depth, bilaFilter->nChannels);
	for (int i = 0; i < 2; i++)
		cvPyrUp(bilaFilter, updata);

	img_gray = cvCreateImage(cvGetSize(input), input->depth, 1);
	cvCvtColor(input, img_gray, CV_RGB2GRAY);

	img_blur = cvCreateImage(cvGetSize(img_gray), img_gray->depth, 1);
	cvSmooth(img_gray, img_blur, CV_MEDIAN, 3, 0, 7.0, 7.0);

	img_edge = cvCreateImage(cvGetSize(img_blur), img_blur->depth, 1);
	cvAdaptiveThreshold(img_blur, img_edge, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY, 9, 2);

	posedge = cvCreateImage(cvGetSize(img_edge), img_edge->depth, 3);
	cvCvtColor(img_edge, posedge, CV_GRAY2RGB);

	result = cvCreateImage(cvGetSize(img_edge), img_edge->depth, 3);
	cvAnd(updata, posedge, result, 0);


	cvShowImage("result", result);

	// 이미지 해제

	cvReleaseImage(&output);
	cvReleaseImage(&bilaFilter);
	cvReleaseImage(&updata);
	cvReleaseImage(&img_gray);
	cvReleaseImage(&img_blur);
	cvReleaseImage(&img_edge);
	cvReleaseImage(&posedge);
	cvReleaseImage(&result);


}*/
/*
#include <opencv/cv.h> // 영상 처리를 위한 header
//#include <opencv/cxcore.h>
//#include <opencv/cvaux.h>
#include <opencv/highgui.h> // 카메라로 영상을 입력받거나 이미지를 읽어들이고 화면에 보여주기

int main(int argc, char** argv)
{
	int col_1, row_1;


	IplImage* img = cvLoadImage("cat.jpg");
	IplImage* img1 = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* img2 = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* dst = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* gray = cvCreateImage(cvGetSize(img), img->depth, 1);
	IplImage* temp = cvCreateImage(cvSize(img->width, img->height), img->depth, img->nChannels);
	IplImage* result = cvCreateImage(cvSize(img->width, img->height), img->depth, img->nChannels);
	cvNamedWindow("Input", CV_WINDOW_AUTOSIZE);
	cvNamedWindow("Output", CV_WINDOW_AUTOSIZE);

	cvShowImage("Input", img);

	cvCvtColor(img, gray, CV_RGB2GRAY); // 흑백변환

	//cvNot(img, img1); // 색상반전
	
	cvSmooth(gray, img1, CV_GAUSSIAN, 21, 21, 0, 0); // 가우시안

	cvDiv(gray, img1, img2, 256);


	//cvMul(img2, gray, dst, 1. / 256);

	//cvCvtColor(dst, result, CV_GRAY2RGB); // 흑백변환

	cvShowImage("Output", img2); // "Output" 윈도우에 img2를 보여주기

	cvWaitKey(0);
	cvReleaseImage(&img); // 연결종료
	
	cvDestroyWindow("Input");
	cvDestroyWindow("Output");
}*/