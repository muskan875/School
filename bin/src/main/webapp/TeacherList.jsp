<!DOCTYPE html>
<html>
<head>
    <title>Teacher List</title>
</head>
<body>

    <h1>Teacher List</h1>
    <div id="teacherList"></div>
    
    <script>
        // Function to fetch data from server and display
        function fetchTeacherData() {
            fetch('TeacherListServlet')
                .then(response => response.json())
                .then(data => {
                    let teacherList = document.getElementById('teacherList');
                    teacherList.innerHTML = '<ul>';
                    data.forEach(teacher => {
                        teacherList.innerHTML += '<li>' + teacher.name + '</li>';
                    });
                    teacherList.innerHTML += '</ul>';
                })
                .catch(error => console.error('Error fetching teacher data:', error));
        }
        
        // Call fetchTeacherData function when page loads
        window.onload = fetchTeacherData;
    </script>

</body>
</html>
