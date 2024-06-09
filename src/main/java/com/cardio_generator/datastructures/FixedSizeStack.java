package com.cardio_generator.datastructures;


//GPT
public class FixedSizeStack<T> {
  private T[] stackArray;
  private int top;
  private int maxSize;

  public FixedSizeStack(int size) {
    this.maxSize = size;
    this.stackArray = (T[]) new Object[maxSize];
    this.top = -1;
  }

  public void push(T value) {
    if (isFull()) {
      throw new StackOverflowError("Stack is full");
    }
    stackArray[++top] = value;
  }

  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stackArray[top--];
  }

  public T remove(int index) {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    T value = stackArray[index];
    for (int i = index; i < top; i++) {
      stackArray[i] = stackArray[i + 1];
    }
    top--;
    return value;
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stackArray[top];
  }

  public boolean isFull() {
    return top == maxSize - 1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public int size() {
    return top + 1;
  }

  public void clear() {
    top = -1;
  }

  public int getMaxSize() {
    return maxSize;
  }
}