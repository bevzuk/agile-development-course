echo "Possible arguments: -i (incremental)"
echo "Passed arguments: $*"

timestamp=`date +"%Y-%m-%d"`

# Generating HTML
# for dir in ./*
# do
#     echo "dir = $dir"
#     cd $dir
#     for f in ./*.markdown
#     do
#         echo "Processing $f"
#         filename=$(basename "$f")
#         filename="${filename%.*}"
    
#         exported_filename="$filename-$timestamp.html"
#         echo "Writing to $exported_filename"
#         pandoc -t slidy "$*" -c ../style/slidy.css $f -o $exported_filename #--self-contained 
#     done
#     cd ..
# done

cd ./01-intro-to-agile/
input=./lec01.markdown
output=../lecture01.html

if [ $input -nt $output ]; then
    pandoc -t slidy --self-contained -c ../style/slidy.css $input -o $output
else
    echo "Nothing new to generate..."
fi

cd ..
cd ./02-clean-code/
input=./lec02.markdown
output=../lecture02.html

if [ $input -nt $output ]; then
    pandoc -t slidy --self-contained -c ../style/slidy.css $input -o $output
else
    echo "Nothing new to generate..."
fi
