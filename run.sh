cat duplicates_full.txt | tail -300 | groovy duff_exists.groovy | groovy duff_json | groovy array2images.groovy | tee index.html

# find  "/e/Drive J/pictures/Other (new)/pictures/misc_sync_master/btt"    -iname "*jpg" -type f -size +1k | duff | tee duplicates2.txt
# cat ~/other/duplicates2.txt | groovy duff_exists.groovy | groovy duff_json.groovy | groovy array2images.groovy | tee index.html
#  cat /Unsorted/new/Photos/duplicates.txt | head -2000  | groovy duff_exists.groovy | grep -v thumbnail | groovy duff_json.groovy | groovy array2images.groovy | tee index.html
