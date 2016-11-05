package model;

import java.io.Serializable;

public class NotAdjacentException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public NotAdjacentException(String s) {
        System.out.println(s);
    }
}
