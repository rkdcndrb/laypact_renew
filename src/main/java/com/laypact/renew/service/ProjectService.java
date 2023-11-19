package com.laypact.renew.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.laypact.renew.domain.Project;
import com.laypact.renew.dto.ProjectDto;
import com.laypact.renew.repository.ProjectQueryRepository;
import com.laypact.renew.repository.ProjectRepository;

@Service
public class ProjectService {
	@Value("${file.upload.location}")
	private String fileUploadPath;
	
	@Autowired 
	ProjectRepository projectRepositoty;
	@Autowired 
	ProjectQueryRepository projectQueryRepositoty;
	
	public Optional<Project> selectProject(ProjectDto dto){
		return projectRepositoty.findById(dto.getSeq());
	}
	
	public List<Project> selectProjectList(ProjectDto dto) {
		if(dto.getUseYn()) {
			return projectRepositoty.findByUseYn(dto.getUseYn()
					, sortBySortOrder().and(sortByYear()));
		}else {
			return projectRepositoty.findAll(sortByYear());
		}
	}
	
	public void deleteProject(long seq) {
		projectRepositoty.deleteById(seq);
	}
	
	public void updateMainYn(long seq, Boolean mainYn) {
		projectRepositoty.updateMainYn(seq, mainYn);
	}
	
	public void saveProject(MultipartHttpServletRequest req) {
		File image= null;
		File thumbnailImage= null;
		String imageNm = "", thumbnailNm="";
		Project dto = null;
		
		try {
			File Folder = new File(fileUploadPath + "/images/");
			if (!Folder.exists()) Folder.mkdir();
			MultipartFile mFile = null;
			if(!req.getFile("image").isEmpty()) {
				mFile = req.getFile("image");
				imageNm = UUID.randomUUID().toString() + "_" + req.getFile("image").getOriginalFilename();
				image = new File(Folder.getAbsolutePath() + "/" +imageNm);
				image.createNewFile();
				mFile.transferTo(image);
				imageNm = "images/"+imageNm;
			}
			if(!req.getFile("thumbnailImage").isEmpty()) {
				mFile = req.getFile("thumbnailImage");
				thumbnailNm = UUID.randomUUID().toString() + "_" + req.getFile("thumbnailImage").getOriginalFilename();
				thumbnailImage = new File(Folder.getAbsolutePath() + "/" +thumbnailNm);
				thumbnailImage.createNewFile();
				mFile.transferTo(thumbnailImage);
				thumbnailNm = "images/"+thumbnailNm;
			}
			
			if(req.getParameterValues("saveMode")[0].equals("I")) {
				dto = Project.builder()
						.company(req.getParameterValues("company")[0])
						.subject(req.getParameterValues("subject")[0])
						.shortDesc(req.getParameterValues("shortDesc")[0])
						.keyword(req.getParameterValues("keyword")[0])
						.year(req.getParameterValues("year")[0])
						.type(req.getParameterValues("type")[0])
						.mainYn(req.getParameterValues("mainYn")[0].equals("true")?true:false)
						.useYn(req.getParameterValues("useYn")[0].equals("true")?true:false)
						.contentsKr(req.getParameterValues("contentsKr")[0])
						.contentsEn(req.getParameterValues("contentsEn")[0])
						.contentsCode(req.getParameterValues("contentsCode")[0])
						.creditCode(req.getParameterValues("creditCode")[0])
						.image(imageNm)
						.thumbnailImage(thumbnailNm)
						.link(req.getParameterValues("link")[0])
						.build();
			}else {
				dto = Project.builder()
						.seq(Long.parseLong(req.getParameterValues("seq")[0]))
						.company(req.getParameterValues("company")[0])
						.subject(req.getParameterValues("subject")[0])
						.shortDesc(req.getParameterValues("shortDesc")[0])
						.keyword(req.getParameterValues("keyword")[0])
						.year(req.getParameterValues("year")[0])
						.type(req.getParameterValues("type")[0])
						.mainYn(req.getParameterValues("mainYn")[0].equals("true")?true:false)
						.useYn(req.getParameterValues("useYn")[0].equals("true")?true:false)
						.contentsKr(req.getParameterValues("contentsKr")[0])
						.contentsEn(req.getParameterValues("contentsEn")[0])
						.contentsCode(req.getParameterValues("contentsCode")[0])
						.creditCode(req.getParameterValues("creditCode")[0])
						.image(imageNm)
						.thumbnailImage(thumbnailNm)
						.link(req.getParameterValues("link")[0])
						.build();
			}
			projectRepositoty.save(dto);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
        }
		
	}
	
	private Sort sortBySortOrder() {
        return Sort.by(Sort.Direction.ASC, "sortOrder");
    }
	
	private Sort sortByYear() {
        return Sort.by(Sort.Direction.ASC, "year");
    }
}
