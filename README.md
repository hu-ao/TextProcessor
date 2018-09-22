# TextProcessor
文本预处理器
输入：
运行程序，输入文本预处理器需要处理的文本字符串text，排版宽度width。
输出：
排版过后的字符串result。

测试用例：
请输入需要预处理的文本:
The main theme of education in engineering school is learning to teach yourself
请输入排版宽度：
30
输出：
The(1); (1);main(1); (1);theme(1); (1);of(1); (1);education(1); (1);in(1); (2);engineering(2); (2);school(2); (2);is(2); (2);learning(2,3); (3);to(3); (3);teach(3); (3);yourself(3);
请输入需要预处理的文本:
So   many whitespaces
请输入排版宽度：
10
输出：
So(1);   (1);many(1); (1);whitespaces(2,3);

构建运行思路：
1.获取文本字符串text进行遍历
2.按排版宽度width依次对文本字符串进行拆分为n段
3.依次获取每个段内每个节的首尾位置，判断该节是否跨两行，并对该节进行遍历输出

