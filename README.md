# lgViewMove
view移动动画

How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Andligang:lgViewMove:v1.0'
	}
	
# 使用说明

	AnimatorPath mPath = new AnimatorPath();
	mPath.moveTo(0, 0);//移动到点
	mPath.lineTo(200, 160);//直线移动
	mPath.cubicTo(300, 300, 400, 400, 600, 200);//贝塞尔曲线移动
	mPath.startAnimation(view, 2000);//view， 时长
