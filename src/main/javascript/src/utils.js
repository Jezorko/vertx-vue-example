export default function getApiUrl() {
    if (process.env && process.env.NODE_ENV === 'development')
        return 'http://localhost:3000/api';
    else
        return `${window.location.protocol}//${window.location.host}/api`;
}