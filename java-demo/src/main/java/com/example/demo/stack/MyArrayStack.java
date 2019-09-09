package com.example.demo.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

import org.apache.tomcat.util.digester.ArrayStack;

/**
 * 面试题：用数组实现栈 
 * 
 * 解题思路：了解掌握ArrayStack的5个基本方法 peek、pop、push、isEmpty、search。
 * 
 * @author wufang 2019-09-09
 *
 */
@SuppressWarnings("rawtypes")
public class MyArrayStack extends ArrayStack {

	private static final long serialVersionUID = -3461702281088978002L;

	// 容量：栈中可存放元素数量
	private int size;
	// 存储数据
	private String[] data;
	private String[] empty_data = {};

	public MyArrayStack() {
		data = empty_data;
	}

	public MyArrayStack(int initialSize) {
		if (initialSize > 0) {
			data = new String[initialSize];
		} else if (initialSize == 0) {
			data = empty_data;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialSize);
		}
	}

	/**
	 * 压栈，向栈中加入元素
	 * 
	 * @param str
	 */
	// TODO 扩容算法再优化一下
	public void push(String str) {
		if (size > data.length) { // 考虑扩容
			data = Arrays.copyOf(data, data.length * 2); // Arrays.copyOf是重点
		}
		data[size++] = str; // 最后别忘将新元素放到栈顶位置
	}

	/**
	 * 查看栈顶元素，但不从栈中真正移除
	 */
	public String peek() {
		if (size == 0) { // 判断栈是否为空
			throw new EmptyStackException();
		}
		return data[size - 1];
	}

	/**
	 * 移除栈顶元素
	 * 
	 * @return 返回被移除的栈顶元素
	 */
	public String pop() {
		String s = this.peek(); // 获取栈顶元素
		size--; // 元素个数减一
		return s;
	}

	/**
	 * 判断栈是否为空
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * 返回对象在栈中的，以1为基数
	 * 
	 * @param str
	 * @return
	 */
	public int research(String str) {
		for (int i = size - 1; i >= 0; i--) {
			if (str == data[i] || (str != null && data[i].equals(str))) {
				return size - i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
//		ArrayStack as = new ArrayStack();
//		as.push("a");
//		as.push("b");
//		as.push("c");
//		System.out.println("栈容量：" + as.size() + "；栈顶元素" + as.peek());
//		System.out.println("弹出栈顶元素：" + as.pop());
//		System.out.println("当前栈容量：" + as.size() + "；栈顶元素" + as.peek());

		MyArrayStack stack = new MyArrayStack(10);
		stack.push("11");
		stack.push("22");
		stack.push("33");
		System.out.println("自定义的栈容量：" + stack.size + "；栈顶元素" + stack.peek());
		System.out.println("自定义弹出栈顶元素：" + stack.pop());
		System.out.println("自定义的当前栈容量：" + stack.size + "；栈顶元素" + stack.peek());

	}

}
