package com.qjx.domain;

import java.nio.ByteBuffer;

public record Package(Header header, ByteBuffer content) {
}
