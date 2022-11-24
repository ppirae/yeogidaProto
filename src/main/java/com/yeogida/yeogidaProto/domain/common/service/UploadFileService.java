package com.yeogida.yeogidaProto.domain.common.service;

import com.yeogida.yeogidaProto.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadFileService {

//    @Value("${file.dir}")
    private String fileDir;

    private final MemberRepository memberRepository;

    public String getFullPath(String filename){
        return fileDir + filename;
    }

    public String createSavedFileName(String originalFilename){
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public String extractExt(String originalFilename){
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

}
