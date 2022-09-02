package com.nesit.bookmyshow._springboot_resful_api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse extends APIResponse {
    private String fileName;
    private String downloadUri;
    private long size;
}
