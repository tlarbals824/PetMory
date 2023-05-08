package com.kusitms.samsion.domain.album.service;

import java.util.List;

import com.kusitms.samsion.common.annotation.DomainService;
import com.kusitms.samsion.domain.album.entity.Album;
import com.kusitms.samsion.domain.album.entity.AlbumImage;
import com.kusitms.samsion.domain.album.repository.AlbumImageRepository;

import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class AlbumImageSaveService {

	private final AlbumImageRepository albumImageRepository;

	public void saveAlbumImageList(List<String> albumImages, Album album) {
		albumImages.forEach(albumImage -> {
			AlbumImage albumImageEntity = new AlbumImage(albumImage, album);
			albumImageRepository.save(albumImageEntity);
		});
	}

}
