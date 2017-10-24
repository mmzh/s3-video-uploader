/**
 * <h1>Lambda function to call video conversion after upload</h1>
 * @author ming
 * @version 1.0.0
 * @since Oct,2017
 */
'use strict';
var AWS = require('aws-sdk');
var s3 = new AWS.S3({
 apiVersion: '2012每09每25'
});
var eltr = new AWS.ElasticTranscoder({
 apiVersion: '2012每09每25',
 region: 'us-east-1'
});
exports.handler = function(event, context) {

 var pipeId='<your pipe id here>';
 var inputBucketId='<your bucket name here>';
 var outputPresetId='<your preset id here>';
 console.log('Executing Elastic Transcoder Start');
 var bucket = event.Records[0].s3.bucket.name;
 var key = event.Records[0].s3.object.key;
 var pipelineId = pipeId;
 if (bucket !== inputBucketId) {
  context.fail('Incorrect Video Input Bucket');
  return;
 }
 var srcKey =  decodeURIComponent(event.Records[0].s3.object.key.replace(/\+/g, " ")); //the object may have spaces  
 var newKey = key.split('.')[0];
 var params = {
  PipelineId: pipelineId,
  OutputKeyPrefix:'',
  Input: {
   Key: srcKey,
   FrameRate: 'auto',
   Resolution: 'auto',
   AspectRatio: 'auto',
   Interlaced: 'auto',
   Container: 'auto'
  },
  Outputs: [{
   Key: newKey + '.ts',
   ThumbnailPattern: '',
   PresetId: outputPresetId, //HLS  400kb/s
   Watermarks: [],
  }]
 };
 console.log('Starting Job');
 eltr.createJob(params, function(err, data){
  if (err){
   console.log(err);
  } else {
   console.log(data);
  }
  context.succeed('ts video is ready!');
 });
};