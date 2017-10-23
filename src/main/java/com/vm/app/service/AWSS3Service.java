package com.vm.app.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

@Service("awss3Service")
public class AWSS3Service {
	
    private final AmazonS3 s3client;
    
    @SuppressWarnings("deprecation")
	public AWSS3Service() { 
    	
        this(new AmazonS3Client() {}); 
    } 
    
    public AWSS3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }
    
    //is bucket exist?
    public boolean doesBucketExist(String bucketName) { 
        return s3client.doesBucketExist(bucketName); 
    } 
    
    //create a bucket
    public Bucket createBucket(String bucketName) { 
        return s3client.createBucket(bucketName); 
    } 

    //list all buckets
    public List<Bucket> listBuckets() { 
        return s3client.listBuckets(); 
    }

    //delete a bucket
    public void deleteBucket(String bucketName) { 
        s3client.deleteBucket(bucketName); 
    }  
    
    //uploading object
    public PutObjectResult putObject(String bucketName, String key, File file, ObjectMetadata metadata) {
    	PutObjectRequest putRequest = new PutObjectRequest(bucketName, key, file);
    	putRequest.setMetadata(metadata);
    	putRequest.setCannedAcl(CannedAccessControlList.PublicRead);
        return s3client.putObject(putRequest);
    }
    
    //listing objects
    public ObjectListing listObjects(String bucketName) {
        return s3client.listObjects(bucketName);
    }
    
    //get an object
    public S3Object getObject(String bucketName, String objectKey) {
        return s3client.getObject(bucketName, objectKey);
    } 
    
    //copying an object
    public CopyObjectResult copyObject(
      String sourceBucketName,
      String sourceKey,
      String destinationBucketName,
      String destinationKey
    ) {
        return s3client.copyObject(
          sourceBucketName, 
          sourceKey, 
          destinationBucketName, 
          destinationKey
        );
    }
    
    //deleting an object
    public void deleteObject(String bucketName, String objectKey) {
        s3client.deleteObject(bucketName, objectKey);
    }
    
    //deleting multiple Objects
    public DeleteObjectsResult deleteObjects(DeleteObjectsRequest delObjReq) {
        return s3client.deleteObjects(delObjReq);
    }
}
