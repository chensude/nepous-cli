package com.nepous.core.result;

import org.apache.commons.lang3.StringUtils;

public class RestResult {

    /**
     * Instantiates a new wrap mapper.
     */
    private RestResult() {
    }

    /**
     * Wrap.
     *
     * @param <E>     the element type
     * @param code    the code
     * @param message the message
     * @param o       the o
     *
     * @return the Result
     */
    public static <E> Result<E> result(int code, String message, E o) {
        return new Result<>(code, message, o);
    }

    /**
     * Wrap.
     *
     * @param <E>     the element type
     * @param code    the code
     * @param message the message
     *
     * @return the Result
     */
    public static <E> Result<E> result(int code, String message) {
        return result(code, message, null);
    }

    /**
     * Wrap.
     *
     * @param <E>  the element type
     * @param code the code
     *
     * @return the Result
     */
    public static <E> Result<E> wrap(int code) {
        return result(code, null);
    }

    /**
     * Wrap.
     *
     * @param <E> the element type
     * @param e   the e
     *
     * @return the Result
     */
    public static <E> Result<E> wrap(Exception e) {
        return new Result<>(Result.ERROR_CODE, e.getMessage());
    }

    /**
     * Un Result.
     *
     * @param <E>     the element type
     * @param Result the Result
     *
     * @return the e
     */
    public static <E> E unWrap(Result<E> Result) {
        return Result.getResult();
    }

    /**
     * Wrap ERROR. code=100
     *
     * @param <E> the element type
     *
     * @return the Result
     */
    public static <E> Result<E> illegalArgument() {
        return result(Result.ILLEGAL_ARGUMENT_CODE_, Result.ILLEGAL_ARGUMENT_MESSAGE);
    }

    /**
     * Wrap ERROR. code=500
     *
     * @param <E> the element type
     *
     * @return the Result
     */
    public static <E> Result<E> error() {
        return result(Result.ERROR_CODE, Result.ERROR_MESSAGE);
    }


    /**
     * Error Result.
     *
     * @param <E>     the type parameter
     * @param message the message
     *
     * @return the Result
     */
    public static <E> Result<E> error(String message) {
        return result(Result.ERROR_CODE, StringUtils.isBlank(message) ? Result.ERROR_MESSAGE : message);
    }

    /**
     * Wrap SUCCESS. code=0
     *
     * @param <E> the element type
     *
     * @return the Result
     */
    public static <E> Result<E> ok() {
        return new Result<>();
    }

    /**
     * Ok Result.
     *
     * @param <E> the type parameter
     * @param o   the o
     *
     * @return the Result
     */
    public static <E> Result<E> ok(E o) {
        return new Result<>(Result.SUCCESS_CODE, Result.SUCCESS_MESSAGE, o);
    }
}
