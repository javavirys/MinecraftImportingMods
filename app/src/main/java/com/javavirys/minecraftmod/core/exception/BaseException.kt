package com.javavirys.minecraftmod.core.exception

abstract class BaseException : RuntimeException {

    constructor() : super()

    constructor(message: String) : super(message)
}